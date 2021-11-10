# PLACE THIS FILE IN THE PROJECT FOLDER ROOT
npm init -y

# Back-end dependencies
npm i express mongoose cors
# Server directory & subdirectories
New-Item -Path . -Name "server" -ItemType Directory
New-Item -Path .\server -Name "config" -ItemType Directory
New-Item -Path .\server -Name "controllers" -ItemType Directory
New-Item -Path .\server -Name "models" -ItemType Directory
New-Item -Path .\server -Name "routes" -ItemType Directory

$ServerJSContent = @"
const express = require("express");
const cors = require("cors");

// Environment vars.
const port = 8000;
const db_name = "NAME_YOUR_DATABASE";

// Immediately execute the import mongoose.config.js function.
require("../config/mongoose.config")(db_name);

const app = express();

// req.body undefined without this!
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(cors());

require("../routes/message.routes")(app);

app.listen(port, () =>
  console.log(``Listening on port `${port} for REQuests to RESpond to.``)
);
"@

New-Item -Path .\server -Name "server.js" -ItemType "file" -Value $ServerJSContent

$MongooseConfigJSContent =  @"
const mongoose = require("mongoose");

// Export a function to be called in server.js
module.exports = (db_name) => {
  mongoose
    .connect(``mongodb://localhost/`${db_name}``, {
      useNewUrlParser: true,
      useUnifiedTopology: true,
      useFindAndModify: false,
    })
    .then(() => {
      console.log(``Successfully connected to `${db_name}``);
    })
    .catch((err) => {
      console.log(``mongoose connection to `${db_name} failed:``, err);
    });
};
"@

New-Item -Path .\server\config -Name "mongoose.config.js" -ItemType "file" -Value $MongooseConfigJSContent

npx create-react-app client

# Front-end dependencies
cd client
npm i axios react-router-dom bootstrap

$IndexJSPath = '.\src\index.js'

# Process lines of text from file and assign result to $NewContent variable
$NewContent = Get-Content -Path $IndexJSPath |
    ForEach-Object {
        # Output the existing line to pipeline in any case
        $_

        # If line matches regex
        if($_ -match ('^' + [regex]::Escape("import reportWebVitals from './reportWebVitals';")))
        {
            "import 'bootstrap/dist/css/bootstrap.css';"
        }
    }

# Write content of $NewContent variable back to file
$NewContent | Out-File -FilePath $IndexJSPath -Encoding Default -Force

# New-Item -Path . -Name "directory name" -ItemType Directory
# New-Item -Path .\server -ItemType Directory

# Add-Type -AssemblyName System.Windows.Forms
# $FileBrowser = New-Object System.Windows.Forms.OpenFileDialog -Property @{ InitialDirectory = [Environment]::GetFolderPath('Desktop') }
# $Null = $FileBrowser.ShowDialog()

# New-Item -Path 'D:\temp\Test Folder' -ItemType Directory

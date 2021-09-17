import './App.css';
import PersonCard from './components/PersonCard';

let peopleArr = [
  {"firstName": "Jane", "lastName": "Doe", "age": 45, "hairColor": "Black"},
  {"firstName": "John", "lastName": "Smith", "age": 88, "hairColor": "Brown"},
  {"firstName": "Millard", "lastName": "Fillmore", "age": 50, "hairColor": "Brown"},
  {"firstName": "Maria", "lastName": "Smith", "age": 62, "hairColor": "Brown"}
]

function App() {
  return (
    <div className="App">
      {/* <header className="App-header">
      </header> */}

      {/* <PersonCard lastName={"Doe"} firstName={"Jane"} age={45} hairColor={"Black"} />
      <PersonCard lastName={"Smith"} firstName={"John"} age={88} hairColor={"Brown"} />
      <PersonCard lastName={"Fillmore"} firstName={"Millard"} age={50} hairColor={"Brown"} />
      <PersonCard lastName={"Smith"} firstName={"Maria"} age={62} hairColor={"Brown"} /> */}
      
      {peopleArr.map((person, key) => {
        return <PersonCard firstName={person.firstName} lastName={person.lastName} age={person.age} hairColor={person.hairColor} key={key} /> // "key" was added to address following error: "Warning: Each child in a list should have a unique "key" prop."
      })}
    </div>
  );
}

export default App;

// Create a component called PersonCard that accepts the following props:

// firstName
// lastName
// age
// hairColor
// Then, display four PersonCard components that show four different people, using props.
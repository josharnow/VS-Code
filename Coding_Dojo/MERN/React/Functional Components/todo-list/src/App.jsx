import React, { useState } from 'react';
import './App.css';
// import BuildList from './components/BuildList'
import List from './components/List'

function App() {
  const [newItem, setNewItem] = useState("");
  const [items, setItems] = useState([]);

  const handleSubmit = e => {
    e.preventDefault();

    if (newItem.length === 0) return;

    const listItem = {
      text: newItem,
      complete: false,
    }

    setItems([...items, listItem]);
    setNewItem("");
  };

  const handleDelete = delIdx => {
    const filteredItems = items.filter((item, i) => i !== delIdx);

    setItems(filteredItems);
  };

  const handleToggleComplete = idx => {
    const updatedItems = items.map((item, i) => {
      if (idx === i) {
        item.complete = !item.complete;
        // Alternatively, do following to avoid mutating item directly:
        // const updatedItem = { ...item, complete: !item.complete };
        // return updatedTodo;
      }
      return item;
    });

    setItems(updatedItems);
  } 

  return (
    <div className="App">
      <form onSubmit={ e => handleSubmit(e) }>
        <input
          onChange={ e => setNewItem(e.target.value) }
          type="text"
          value={ newItem }
        />
        <div>
          <button>Add</button>
        </div>
      </form>

      <hr />

      {List.map((item, i) => {
        return (
          <List
            key={i}
            i={i}
            item={item}
            handleToggleComplete={handleToggleComplete}
            handleDelete={handleDelete}
          />
        );
      })}

    </div>
  );
}
export default App;
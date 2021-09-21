import React from "react";

const List = props => {
  const itemClasses = ["bold", "italic"];

  if (props.item.complete) {
    itemClasses.push("line-through");
  }

  return (
    <React.Fragment>
      <input
        onChange={ e => props.handleToggleComplete(props.i) }
        checked={ props.item.complete }
        type="checkbox"
      />
      <span className={ itemClasses.join(" ") }>{ props.list.text }</span>
      <button
        onClick={ e => { props.handleListDelete(props.i) } }
        className="Button"
      >
        Delete
      </button>
    </React.Fragment>
  )
};

export default List;

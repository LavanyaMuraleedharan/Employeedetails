import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
const Employeeadd = () => {
  const [Name, setName] = useState("");
  const [Role, setRole] = useState("");
  const [Email, setEmail] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();
    const newEmployee = {
      name: Name,
      role: Role,
      email: Email,
    };
    try {
      fetch("http://localhost:8080/api/employees", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(newEmployee),
      }).then((response) => {
        console.log("Response object:", response);
        if (response.ok) {
          alert("Employee added successfully!");
          navigate("/employees");
        } else {
          alert("Failed to add employee.");
        }
      });
    } catch (error) {
      console.error("Error adding employee:", error);
      alert("An error occurred while adding the employee.");
    }
  };

  function handleNameChange(event) {
    setName(event.target.value);
  }
  function handleRoleChange(event) {
    setRole(event.target.value);
  }
  function handleEmailChange(event) {
    setEmail(event.target.value);
  }

  return (
    <div>
      <h2>Add New Employee</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="name" className="form-label">
            Name
          </label>
          <input
            type="text"
            className="form-control"
            id="name"
            placeholder="Enter name"
            value={Name}
            onChange={handleNameChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="role" className="form-label">
            Role
          </label>
          <input
            type="text"
            className="form-control"
            id="role"
            placeholder="Enter role"
            value={Role}
            onChange={handleRoleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="email" className="form-label">
            Email
          </label>
          <input
            type="email"
            className="form-control"
            id="email"
            placeholder="Enter email"
            value={Email}
            onChange={handleEmailChange}
          />
        </div>
        <button type="submit" className="btn btn-primary">
          Add Employee
        </button>
      </form>
    </div>
  );
};

export default Employeeadd;

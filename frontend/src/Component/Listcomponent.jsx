import React, { useEffect } from "react";
import { getEmployees } from "../services/Employeeservice";
import { useNavigate } from "react-router-dom";

const Listcomponent = () => {
  const useState = React.useState;
  const [employees, setEmployees] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    getEmployees()
      .then((data) => setEmployees(data))
      .catch((error) => console.error(error));
  }, []);
  function addNewEmployee() {
    navigate("/add-employee");
  }
  return (
    <div>
      <h2>List of employees</h2>
      <button
        type="button"
        onClick={addNewEmployee}
        className="btn btn-primary"
      >
        Add Employee
      </button>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Role</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.name}</td>
              <td>{employee.role}</td>
              <td>{employee.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Listcomponent;

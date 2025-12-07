import "./App.css";
import Header from "./Component/Header";
import Listcomponent from "./Component/Listcomponent";
import { Routes, Route } from "react-router-dom";
import { BrowserRouter as Router } from "react-router-dom";
import Employeeadd from "./Component/Employeeadd";
function App() {
  return (
    <>
      <Router>
        <Header title="Employee List" subtitle="Manage your team" />
        <main className="container my-4">
          <Routes>
            <Route path="/" element={<Listcomponent />} />
            <Route path="/employees" element={<Listcomponent />} />
            <Route path="/add-employee" element={<Employeeadd />} />
          </Routes>
        </main>
      </Router>
    </>
  );
}

export default App;

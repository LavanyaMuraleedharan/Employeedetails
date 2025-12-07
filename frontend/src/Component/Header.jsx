import React from "react";
import "./Header.css";

const Header = ({ title = "Employee Manager", subtitle }) => {
  return (
    <header className="app-header">
      <div className="container header-inner">
        <h1 className="app-title">{title}</h1>
        {subtitle && <p className="app-subtitle">{subtitle}</p>}
      </div>
    </header>
  );
};

export default Header;

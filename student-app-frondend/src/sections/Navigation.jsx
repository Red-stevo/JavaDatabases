import  NavLink from 'react-bootstrap/NavLink';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link, BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Home from '../pages/Home.jsx';
import Add from '../pages/Add.jsx';
import View from '../pages/View.jsx';


const Navigation = () =>{
  return (
    <Navbar bg="dark" data-bs-theme="dark"  expand="lg" className="bg-body-tertiary">
      <Container>
      <Navbar.Brand id="basic-nav" >Student App</Navbar.Brand>
      <Navbar.Toggle aria-controls='basic-navbar-nav' />
      <Navbar.Collapse id='basic-navbar-nav'>
      <Router>
      <Nav className='me-auto' >
      <NavLink as={Link} to={"/home"} >Home</NavLink>
      <NavLink as={Link} to={"/add-student"}>Add Student</NavLink>
      <NavLink as={Link} to={"/view-students"}>View Students</NavLink>
      </Nav>
      </Router>
      <>
      <Switch>
          <Route path="/home">
            <Home></Home>
          </Route>
          <Route path="/add-student">
            <Add></Add>
          </Route>
          <Route path="/view-students">
              <View></View>
          </Route>
      </Switch>
      </>
      </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}


export default Navigation;
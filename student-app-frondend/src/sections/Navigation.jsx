import  NavLink from 'react-bootstrap/NavLink';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';


const Navigation = () =>{
  return (
    <Navbar bg="dark" data-bs-theme="dark"  expand="lg" className="bg-body-tertiary">
      <Container>
      <Navbar.Brand id="basic-nav" >Student App</Navbar.Brand>
      <Navbar.Toggle aria-controls='basic-navbar-nav' />
      <Navbar.Collapse id='basic-navbar-nav'>
      <Nav className='me-auto' >
      <NavLink href='#Home'>Home</NavLink>
      <NavLink href='#add student'>Add Student</NavLink>
      <NavLink href='#view students'>View Students</NavLink>
      </Nav>
      </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}


export default Navigation;
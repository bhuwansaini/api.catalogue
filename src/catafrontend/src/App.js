import logo from './logo.svg';
import './App.css';
import React, { Component} from 'react';
import { Spin, List} from 'antd';
import Icon from '@ant-design/icons';
import { Row, Col, Table} from 'reactstrap';
import {Container, Card, Button} from 'react-bootstrap';


const checkStatus = response => {
  if (response.ok) {
      return response;
  } else {
      let error = new Error(response.statusText);
      error.response = response;
      response.json().then(e => {
          error.error = e;
      });
      return Promise.reject(error);
  }
}
const getIndicatorIcon = () => <Icon type="loading" style={{ fontSize: 24 }} spin />;

export const getAllApis = () => 
  fetch('http://localhost:8080/api-catalogue/v1/api', { mode: 'no-cors'});
  
class App extends Component  {

  state = {
    apilist: [],
    isFetching: false
  }

  componentDidMount ()
  {
    this.fetchApis();
  }

  fetchApis = () => {
    this.setState({
      isFetching: true
    });
    
    fetch('http://localhost:8080/api-catalogue/v1/api')
      .then(res => res.json()
      .then(apilist => {
        console.log(apilist);
        this.setState({
          apilist,
          isFetching: false
        });
      }))
      .catch(error => {
        console.log(error);
        this.setState({
          isFetching: false
        });
      });
  }


  render () {
    const { apilist, isFetching} = this.state;
    console.log(apilist);

    if (isFetching) {
      return (
        <Container>
          <Spin indicator={getIndicatorIcon()}/>
        </Container>
      );
    }

    const list = [
      {
          "id": 1,
          "firstName": "abc",
          "lastName": "xyz",
      },
  
      {
          "id": 2,
          "firstName": "def",
          "lastName": "uvz",
      }
    ]

    return (
      <Container>
        <div>
          <h1> APIs</h1>
          {/* <ul>        
                {apilist.map(el => {
                  return (
                  <li>{el.name}</li>
                  );
                })}
          </ul> */}

          {apilist.map(el => {
                  return (
                    <Card style={{ width: '18rem' }}>
                    <Card.Img variant="top" src="holder.js/100px180" />
                    <Card.Body>
                    <Card.Title>{el.name}</Card.Title>
                    <Card.Text>
                      Some quick example text to build on the card title and make up the bulk of
                      the card's content.
                    </Card.Text>
                    <Button variant="primary">View Documentation</Button>
                    </Card.Body>
                    </Card>
                  );
          })}
          
        </div>     
        </Container>
    );
  }
}

export default App;

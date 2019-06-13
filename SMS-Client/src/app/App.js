import React, { Component } from 'react';
import './App.css';
import {
  Route,
  withRouter,
  Switch
} from 'react-router-dom';

import { getCurrentUser } from '../util/APIUtils';
import { ACCESS_TOKEN } from '../constants';

import PollList from '../poll/PollList';
import NewPoll from '../poll/NewPoll';
import Login from '../user/login/Login';
import Signup from '../user/signup/Signup';
import Profile from '../user/profile/Profile';
import AppHeader from '../common/AppHeader';
import NotFound from '../common/NotFound';
import LoadingIndicator from '../common/LoadingIndicator';
import PrivateRoute from '../common/PrivateRoute';

import AddQuestion from '../question/AddQuestion';
import ListQuestions from '../question/ListQuestions';
import {without } from 'lodash';

import { Layout, notification } from 'antd';
const { Content } = Layout;

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      currentUser: null,
      isAuthenticated: false,
      isLoading: false,
      myQuestions: [],
      formDisplay: false,
      orderBy: 'questionText',
      orderDir: 'asc',
      queryText: '',
      lastIndex: 0
    }
    this.handleLogout = this.handleLogout.bind(this);
    this.loadCurrentUser = this.loadCurrentUser.bind(this);
    this.handleLogin = this.handleLogin.bind(this);
    this.deleteQuestion = this.deleteQuestion.bind(this);
    this.toggleForm = this.toggleForm.bind(this);
    this.addQuestion = this.addQuestion.bind(this);
    this.changeOrder = this.changeOrder.bind(this);
    //this.searchApts = this.searchApts.bind(this);
   // this.updateInfo = this.updateInfo.bind(this);

    notification.config({
      placement: 'topRight',
      top: 70,
      duration: 3,
    });    
  }


  toggleForm() {
    this.setState({
      formDisplay: !this.state.formDisplay
    });
  }


  changeOrder(order, dir) {
    this.setState({
      orderBy: order,
      orderDir: dir
    });
  }

 /** updateInfo(name, value, id) {
    let tempApts = this.state.myAppointments;
    let aptIndex = findIndex(this.state.myAppointments, {
      aptId: id
    });
    tempApts[aptIndex][name] = value;
    this.setState({
      myAppointments: tempApts
    });
  }*/ 

  addQuestion(que) {
    let tempQues = this.state.myQuestions;
    que.queId = this.state.lastIndex;
    tempQues.unshift(que);
    this.setState({
      myQuestions: tempQues,
      lastIndex: this.state.lastIndex + 1
    });
  }

  deleteQuestion(que) {
    let tempQues = this.state.myQuestions;
    tempQues = without(tempQues, que);

    this.setState({
      myQuestions: tempQues
    });
  }

  loadCurrentUser() {
    this.setState({
      isLoading: true
    });
    getCurrentUser()
    .then(response => {
      this.setState({
        currentUser: response,
        isAuthenticated: true,
        isLoading: false
      });
    }).catch(error => {
      this.setState({
        isLoading: false
      });  
    });
  }

  componentDidMount() {
    this.loadCurrentUser();
    fetch('./data.json')
      .then(response => response.json())
      .then(result => {
        const ques = result.map(item => {
          item.queId = this.state.lastIndex;
          this.setState({ lastIndex: this.state.lastIndex + 1 });
          return item;
        });
        this.setState({
          myQuestions: ques
        });
      });
  }

  handleLogout(redirectTo="/", notificationType="success", description="You're successfully logged out.") {
    localStorage.removeItem(ACCESS_TOKEN);

    this.setState({
      currentUser: null,
      isAuthenticated: false
    });

    this.props.history.push(redirectTo);
    
    notification[notificationType]({
      message: 'Polling App',
      description: description,
    });
  }

  handleLogin() {
    notification.success({
      message: 'Polling App',
      description: "You're successfully logged in.",
    });
    this.loadCurrentUser();
    this.props.history.push("/");
  }

  render() {
    let order;
    let filteredQues = this.state.myQuestions;
    if (this.state.orderDir === 'asc') {
      order = 1;
    } else {
      order = -1;
    }
    filteredQues = filteredQues
    .sort((a, b) => {
      if (
        a[this.state.orderBy].toLowerCase() <
        b[this.state.orderBy].toLowerCase()
      ) {
        return -1 * order;
      } else {
        return 1 * order;
      }
    })
    .filter(eachItem => {
      return (
        eachItem['questionText']
          .toLowerCase()
          .includes(this.state.queryText.toLowerCase()) ||
        eachItem['createdBy']
          .toLowerCase()
          .includes(this.state.queryText.toLowerCase()) ||
        eachItem['questionAnswer']
          .toLowerCase()
          .includes(this.state.queryText.toLowerCase())
      );
    });

    if(this.state.isLoading) {
      return <LoadingIndicator />
    }
    return (
        <Layout className="app-container">
          <AppHeader isAuthenticated={this.state.isAuthenticated} 
            currentUser={this.state.currentUser} 
            onLogout={this.handleLogout} />

          <Content className="app-content">
            <div className="container">
              <Switch>      
                <Route exact path="/" 
                  render={(props) => <PollList isAuthenticated={this.state.isAuthenticated} 
                      currentUser={this.state.currentUser} handleLogout={this.handleLogout} {...props} />}>
                </Route>
                <Route path="/login" 
                  render={(props) => <Login onLogin={this.handleLogin} {...props} />}></Route>
                <Route path="/signup" component={Signup}></Route>
                <Route path="/users/:username" 
                  render={(props) => <Profile isAuthenticated={this.state.isAuthenticated} currentUser={this.state.currentUser} {...props}  />}>
                </Route>
                <PrivateRoute authenticated={this.state.isAuthenticated} path="/poll/new" component={NewPoll} handleLogout={this.handleLogout}></PrivateRoute>
                <PrivateRoute authenticated={this.state.isAuthenticated} path="/question/new" component={AddQuestion} handleLogout={this.handleLogout}></PrivateRoute>
                <Route component={NotFound}></Route>
              </Switch>

              <main className="page bg-white" id="petratings">
<div className="container">
  <div className="row">
    <div className="col-md-12 bg-white">
      <div className="container">
        <AddQuestion
          formDisplay={this.state.formDisplay}
          toggleForm={this.toggleForm}
          addAppointment={this.addQuestion}
        />
        <ListQuestions
          appointments={filteredQues}
          deleteQuestion={this.deleteQuestion}
          updateInfo={this.updateInfo}
        />
      </div>
    </div>
  </div>
</div>
</main>
            </div>
          </Content>
        </Layout>



    );
  }
}

export default withRouter(App);

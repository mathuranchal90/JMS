import React, { Component } from 'react';
import { FaPlus } from 'react-icons/fa';

class AddQuestion extends Component {

    constructor(){
        super();
        this.state={
            questionNo:'',
            questionText:'',
            questionSubject:'',
            Option1:'',
            Option2:'',
            Option3:'',
            Option4:'',
            questionAnswer:'',
            createdDate:'',
            createdBy:''

        };

        this.handleChange=this.handleChange.bind(this);
        this.handleAdd=this.handleAdd.bind(this);
    }
    
    handleAdd(e){
        e.preventDefault();
        let tempQue={
            questionNo:this.state.questionNo,
            questionText:this.state.questionText,
            questionSubject:this.state.questionSubject,
            Option1:this.state.Option1,
            Option2:this.state.Option2,
            Option3:this.state.Option3,
            Option4:this.state.Option4,
            questionAnswer:this.state.questionAnswer,
            createdDate:this.state.createdDate,
            createdBy:this.state.createdBy
        };

        this.props.AddQuestion(tempQue);

        this.setState({
            questionNo:'',
            questionText:'',
            questionSubject:'',
            Option1:'',
            Option2:'',
            Option3:'',
            Option4:'',
            questionAnswer:'',
            createdDate:'',
            createdBy:''  
        });

        this.props.toggleForm();
    }


    handleChange(e) {
        const target = e.target;
        const value = target.value;
        const name = target.name;
    
        this.setState({
          [name]: value
        });
      }


      render(){
          return(
              <div className={'card textcenter mt-3 ' +(this.props.formDisplay ? '' : 'add-appointment')}>
              <div
          className="apt-addheading card-header bg-primary text-white"
          onClick={this.props.toggleForm}
        >
          <FaPlus /> Add Question
        </div>

        <div className="card-body">
          <form id="aptForm" noValidate onSubmit={this.handleAdd}>
            <div className="form-group form-row">
              <label
                className="col-md-2 col-form-label text-md-right"
                htmlFor="questionNo"
                readOnly
              >
                Question No
              </label>
              <div className="col-md-10">
                <input
                  type="text"
                  className="form-control"
                  name="questionNo"
                  placeholder="Question No"
                  value={this.state.questionNo}
                  onChange={this.handleChange}
                />
              </div>
            </div>

            <div className="form-group form-row">
              <label
                className="col-md-2 col-form-label text-md-right"
                htmlFor="questionText"
              >
                Question Text
              </label>
              <div className="col-md-10">
                <input
                  type="text"
                  className="form-control"
                  name="questionText"
                  placeholder="Question Text"
                  value={this.state.questionText}
                  onChange={this.handleChange}
                />
              </div>
            </div>

            <div className="form-group form-row">
              <label
                className="col-md-2 col-form-label text-md-right"
                htmlFor="questionSubject"
              >
                Question Subject
              </label>
              <div className="col-md-4">
                <input
                  type="text"
                  className="form-control"
                  name="questionSubject"
                  id="questionSubject"
                  value={this.state.questionSubject}
                  onChange={this.handleChange}
                />
              </div>
              <label
                className="col-md-2 col-form-label text-md-right"
                htmlFor="Option1"
              >
                Option1
              </label>
              <div className="col-md-4">
                <input
                  type="text"
                  className="form-control"
                  name="Option1"
                  id="Option1"
                  value={this.state.Option1}
                  onChange={this.handleChange}
                />
              </div>
            </div>

            <div className="form-group form-row">
              <label
                className="col-md-2 col-form-label text-md-right"
                htmlFor="Option2"
              >
                Option2
              </label>
              <div className="col-md-4">
                <input
                  type="text"
                  className="form-control"
                  name="Option2"
                  id="Option2"
                  value={this.state.Option2}
                  onChange={this.handleChange}
                />
              </div>
              <label
                className="col-md-2 col-form-label text-md-right"
                htmlFor="Option3"
              >
                Option3
              </label>
              <div className="col-md-4">
                <input
                  type="text"
                  className="form-control"
                  name="Option3"
                  id="Option3"
                  value={this.state.Option3}
                  onChange={this.handleChange}
                />
              </div>
            </div>

            <div className="form-group form-row">
              <label
                className="col-md-2 col-form-label text-md-right"
                htmlFor="Option4"
              >
                Option4
              </label>
              <div className="col-md-4">
                <input
                  type="text"
                  className="form-control"
                  name="Option4"
                  id="Option4"
                  value={this.state.Option4}
                  onChange={this.handleChange}
                />
              </div>
              <label
                className="col-md-2 col-form-label text-md-right"
                htmlFor="questionAnswer"
              >
                Question Answer
              </label>
              <div className="col-md-4">
                <input
                  type="text"
                  className="form-control"
                  name="questionAnswer"
                  id="questionAnswer"
                  value={this.state.questionAnswer}
                  onChange={this.handleChange}
                />
              </div>
            </div>

            <div className="form-group form-row">
              <label
                className="col-md-2 col-form-label text-md-right"
                htmlFor="createdDate"
              >
                createdDate
              </label>
              <div className="col-md-4">
                <input
                  type="text"
                  className="form-control"
                  name="createdDate"
                  id="createdDate"
                  value={this.state.createdDate}
                  onChange={this.handleChange}
                />
              </div>
              <label
                className="col-md-2 col-form-label text-md-right"
                htmlFor="createdBy"
              >
                created By
              </label>
              <div className="col-md-4">
                <input
                  type="text"
                  className="form-control"
                  name="createdBy"
                  id="createdBy"
                  value={this.state.createdBy}
                  onChange={this.handleChange}
                />
              </div>
            </div>

            <div className="form-group form-row mb-0">
              <div className="offset-md-2 col-md-10">
                <button
                  type="submit"
                  className="btn btn-primary d-block ml-auto"
                >
                  Add Question
                </button>
              </div>
            </div>
          </form>
        </div>



              </div>
          )
      }
}

export default AddQuestion;
import React, { Component } from 'react';
import { FaTimes } from 'react-icons/fa';
import Moment from 'react-moment';

class ListQuestions extends Component {

    render(){

        return(
            <div className="appointment-list item-list mb-3">

            {
                this.props.questions.map(item =>(
                    <div className="pet-item col media py-3" key={item.queId}>
                    <div className="mr-3">
                    <button
                className="pet-delete btn btn-sm btn-danger"
                onClick={() => this.props.deleteQuestion(item)}
              >
              <FaTimes />
              </button>
            </div>

            <div className="pet-info media-body">
              <div className="pet-head d-flex">
                <span
                  className="pet-name"
                  contentEditable
                  suppressContentEditableWarning
                  onBlur={e =>
                    this.props.updateInfo(
                      'questionText',
                      e.target.innerText,
                      item.queId
                    )
                  }
                  >
                  {item.queId}--{item.questionText}
                  </span>
                  <span className="apt-date ml-auto">
                    <Moment
                      date={item.createdDate}
                      parse="YYYY-MM-dd hh:mm"
                      format="MMM-d h:mma"
                    />
                  </span>
                </div>

                <div className="owner-name">
                <span className="label-item">Created By: </span>
                <span
                  contentEditable
                  suppressContentEditableWarning
                  onBlur={e =>
                    this.props.updateInfo(
                      'ownerName',
                      e.target.innerText,
                      item.queId
                    )
                  }
                >
                  {item.createdBy}
                </span>
              </div>

              <div
                className="apt-notes"
                contentEditable
                suppressContentEditableWarning
                onBlur={e =>
                  this.props.updateInfo(
                    'questionAnswer',
                    e.target.innerText,
                    item.queId
                  )
                }
              >
                {item.questionAnswer}
              </div>
              </div>
          </div>
  

                ))
            }
            
            </div>
        )
    }

}

export default ListQuestions;
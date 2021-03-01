import './index.css';
import React,{Component} from 'react';
import {Redirect} from 'react-router-dom';

import loader from '../../images/38.gif';
import logo from '../../images/logo.png';


class Questions extends Component {
    
    constructor(props) {
        super(props);

        this.state = {
            loading: true,
            redirect: false,
            selectedOption: "idaVolta",
            responses: [],
            nextQuestion: {},
            loose: false,
            win: false
        };

        this.radio = React.createRef();        
        this.clickBtn = this.clickBtn.bind(this);
    }

    onValueChange = (event) => {
        this.setState({selectedOption: event.target.value});        
    }    

    setValues = (values) => {
        let next = values.shift();
        this.setState({nextQuestion: next, 
                       selectedOption: next.answers[0], 
                       responses: values,
                       loading: false});                       
    }
   
    clickBtn = () => {
        if(this.state.selectedOption == this.state.nextQuestion.resultAnswer) {

            if(this.state.responses.length === 0) this.setState({win: true});
            else this.setValues(this.state.responses);            
        }
        else this.setState({loose: true});        
    }
        
    async componentDidMount() {

        let xhttp = new XMLHttpRequest();
        
        const responses = () => {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                this.setValues(JSON.parse(xhttp.responseText));
            }    
        }  
        xhttp.onreadystatechange = responses;            
        xhttp.open("GET", "https://api-quiz-game.herokuapp.com/questions", true);
        xhttp.send();         
    }


    render() {

        return (
            <div className="header">  

                <img src={logo} alt="logo" />

                {this.state.loading && 
                    <div id="loader"><img src={loader} alt="loader" /></div>
                }

                {this.state.redirect && <Redirect to="/"/>}

                <div className={(this.state.loose || this.state.win) ? "game-over" : "hide"}>
                    <div className={this.state.loose ? "overlay" : "hide"}></div>
                    <div className="block-final">
                        <div className={this.state.loose ? "msg-loose" : "hide"}>Você perdeu o jogo!</div>
                        <div className={this.state.loose ? "hide" : ""}>Parabens! Você venceu o jogo.</div>
                        <button className={this.state.loose ? "btn-loose" : "btn-win"}
                                onClick={() => this.setState({redirect: true})} >
                            Recomeçar
                        </button>
                    </div>
                </div>                
                
                {!this.state.loading && !this.state.win &&

                    <div>
                        <form>                         
                                <div className="question">{this.state.nextQuestion.question}</div>

                                <div id="radios">                  
                                        {this.state.nextQuestion.answers.map((answer) => 
                                            <div className="radio">
                                                <label className="containerRadio">
                                                    <input type="radio" disabled={this.state.loose} name="radioAnswer" value={answer} 
                                                    checked={this.state.selectedOption === answer}
                                                    onChange={e => this.onValueChange(e)} />
                                                    <span className="checkmark"></span>
                                                </label>
                                                <a>{answer}</a>
                                            </div>   
                                        )}                                                                       
                                </div>                        
                        </form>                
                        
                        <button id="btnConfirm" disabled={this.state.loose} onClick={this.clickBtn}>
                            Confirmar
                        </button>
                    </div> 
                }    

            </div>
        );
    }
}

export default Questions;
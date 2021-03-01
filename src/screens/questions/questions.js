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
            valorForm: ""
        };

        this.radio = React.createRef();
        
        this.btn = React.createRef();
        
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
            this.setValues(this.state.responses);            
        }
    }

        
    async componentDidMount() {

        var xhttp = new XMLHttpRequest();
        
        const responses = () => {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                this.setValues(JSON.parse(xhttp.responseText));
            }    
        }  
        xhttp.onreadystatechange = responses;            
        xhttp.open("GET", "http://localhost:8080/questions", true);
        xhttp.send();         
    }

    getRadio = (value) => {        
        return(
            <div className="radio">

                <label className="containerRadio">
                    <input type="radio" name="radioBusca" value={value} 
                    checked={this.state.selectedOption === value}
                    onChange={e => this.onValueChange(e)} />
                    <span className="checkmark"></span>
                </label>
                <a>{value}</a>
            </div>   
        );
    }


    render() {

        return (
            <div className="header">  

                <img src={logo} alt="logo" />

                <div className="game-over">
                    <div className="overlay"></div>
                    <div className="msg-loose">
                        <div>Você perdeu o jogo!</div>
                        <button className="btn-final">Recomeçar</button>
                    </div>
                </div>
                
                
                {!this.state.loading &&

                    <div>
                        <form>                         
                                <div className="question">{this.state.nextQuestion.question}</div>

                                <div id="radios">                  

                                        {this.getRadio(this.state.nextQuestion.answers[0])}
                                        {this.getRadio(this.state.nextQuestion.answers[1])}
                                        {this.getRadio(this.state.nextQuestion.answers[2])}
                                        {this.getRadio(this.state.nextQuestion.answers[3])}
                                        {this.getRadio(this.state.nextQuestion.answers[4])}                            
                                </div>                        
                        </form>                
                        
                        <button id="btnBuscar" onClick={this.clickBtn}>Confirmar</button>
                    </div> 
                }    

            </div>
        );
    }
}

export default Questions;
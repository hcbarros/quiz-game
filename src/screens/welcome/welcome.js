import './index.css';
import React,{Component} from 'react';
import {Redirect} from 'react-router-dom';
import logo from '../../images/logo.png';


class Welcome extends Component {
    state = {    
      redirect: false
    };

    async componentDidMount() {

        var xhttp = new XMLHttpRequest();
        xhttp.open("DELETE", "http://localhost:8080/questions", true);
        xhttp.send();                      
    }

    render() {

        return (

            <div className="header">           

                <img src={logo} alt="logo" />     

                <div className="init">            
                    {this.state.redirect && <Redirect to="/questions"/>}

                    <div className="welcome-text" >
                        <p>Bem vindo ao Quiz Game!</p>   
                        <a>Clique no botao abaixo para acessar as perguntas.</a>
                    </div>
                                                
                    <button className="btn-start" onClick={() => this.setState({redirect: true})} >
                        Iniciar
                    </button>                
                </div>

            </div>
        );
    }
}

export default Welcome;
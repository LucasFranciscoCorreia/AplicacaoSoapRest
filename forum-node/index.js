const app = require('express')();
const soap = require('soap');
const bodyparser = require('body-parser');
const cors = require('cors');
const axios = require('axios');

const http = axios.create({
    baseURL: 'http://localhost:4200',
    headers: {
        'Content-type': 'application/json'
    }
})

app.use(bodyparser.urlencoded({ extended: false }));
app.use(bodyparser.json());
app.use(cors());

const url = 'http://localhost:8000/?wsdl'

app.post('/login', (request, response) => {
  soap.createClient(url, (err, client) => {
      if(err){
          console.log(err)
      }else{
          client.validarLogin({
              arg0: request.body.usuario,
              arg1: request.body.senha
          }, (err, res)=> {
              if(err)
                  console.log(err)
              else
                  response.send(res.return);
          })
      }
  });
});

app.post('/topico', (request, response) => {
    http.post('/topico', request.body);
})

app.get('/topico', (request, response) => {
    http.get('/topico', request.body).then((result) => {
        response.send(result.data);
    });
})

app.post('/mensagem', (request, response) => {
    http.post('/mensagem', request.body).then(()=> {
        response.send(undefined);
    })
})

app.get('/mensagem', (request, response) => {
    http.get('/mensagem').then((result, err) => {
        response.send(result.data);
    });
})

app.get('/mensagem/:idTopico', (request, response) => {
    http.get(`/mensagem/${request.params.idTopico}`).then((result, err)=> {
        response.send(result.data);
    })
})

app.listen(3000, () => {
  console.log('listening on *:3000');
});
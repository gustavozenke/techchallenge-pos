import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
stages: [
    { duration: '5m', target: 200 }, // traffic ramp-up from 1 to a higher 200 users over 10 minutes.
    { duration: '5m', target: 200 }, // stay at higher 200 users for 30 minutes
    { duration: '5m', target: 0 }, // ramp-down to 0 users
  ],
};

export default function () {
  const url = 'http://127.0.0.1:41071/pedido';
  const payload = JSON.stringify({
                                 	"cliente": {
                                 		"cpf": "37451879895",
                                 		"nome": "danilo",
                                 		"email": "email@email.com",
                                 		"marketing": true
                                 	},
                                 	"lanches": [
                                 		{
                                 			"nome": "Whooper Junior",
                                 			"nome_banco": "whooper_junior",
                                 			"descricao": "hamburguer",
                                 			"preco": 30.0
                                 		},
                                 		{
                                 			"nome": "Whooper Junior",
                                 			"nome_banco": "whooper_junior",
                                 			"descricao": "hamburguer",
                                 			"preco": 30.0
                                 		}
                                 	],
                                 	"bebidas": [
                                 		{
                                 			"nome": "Soda",
                                 			"nome_banco": "soda",
                                 			"descricao": "Dolly Citrus",
                                 			"preco": 2.0,
                                 			"tamanho": "p"
                                 		}
                                 	],
                                 	"sobremesas": [
                                 		{
                                 			"nome": "Tortinha de Morango",
                                 			"nome_banco": "tortinha_de_morango",
                                 			"descricao": "tortinha de morango",
                                 			"preco": 12.0
                                 		}
                                 	],
                                 	"acompanhamentos": [
                                 		{
                                 			"nome": "Batata Frita",
                                 			"nome_banco": "batata_frita",
                                 			"descricao": "Batata Frita",
                                 			"preco": 7.0
                                 		}
                                 	]
                                 });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  http.post(url, payload, params);
  sleep(1);
}
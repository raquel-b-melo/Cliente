# ProjetoCliente

Para validação no POSTMAN:

{
	"info": {
		"_postman_id": "99084b9d-3a5a-4daf-bd0e-02626d589113",
		"name": "ClienteAPI",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "Inserir Dados",
			"request": {
				"method": "POST",
				"header": [],
				"url": {
					"raw": "localhost:8080/clientes/insert",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"clientes",
						"insert"
					]
				}
			},
			"response": []
		},
		{
			"name": "Consultar por ID",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost:8080/clientes/getById/1",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"clientes",
						"getById",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "Consultar Todos",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost:8080/clientes",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"clientes"
					]
				}
			},
			"response": []
		}
	]
}
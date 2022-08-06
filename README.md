# 概要
バナナチームのCRUD-RESTfulAPIアプリです。

## 環境
Java 11  
Spring Boot 2.6.3

## DockerでのMySQL起動方法

### 起動手順
`ディレクトリ「banana-crud-restfulapi」に移動する`  

`$ docker-compose up -d`  
コンテナを構築

### 確認方法
`$ docker ps`  
コンテナ名を確認する

### MySQL 操作
MySQLにログインし、DBを確認するまでの手順を記載する。

### ログイン
`$ docker exec -it [コンテナ名] mysql -uroot -p`  

### DB選択
`$ show databases;`

`$ use [DB名];`

`$ show tables;`  
初期テーブルが作成されていることを確認する

### 終了手順
`$ docker-compose down`  
コンテナを停止

## GET /users
名前と誕生日をもとにユーザ検索を行う。  
URIは、以下を参考に入力すること。
### URI フォーマット
`http://localhost:8080/users?name=名前&birthdate=誕生日`

### URI 実例
`http://localhost:8080/users?name=A&birthdate=2022-01-01`

# f290-tesi-mariadb-crud

## Scripts SQL

```sql
create database fatec;
use fatec;
drop table user;

create table user(
	id int primary key auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    username varchar(12) not null,
    passwd varchar(100) not null
);

INSERT INTO `fatec`.`user`
(`name`,`email`,`username`,`passwd`) 
VALUES
('Aluno Fatec', 'aluno@gmail.com','alunof290', des_encrypt('segredo@#345','fatec'));

select des_encrypt('123456', 'fatec'), des_decrypt(des_encrypt('123456', 'fatec'), 'fatec');

SELECT DES_DECRYPT(DES_ENCRYPT('segredo@#345','fatec'),'fatec');
```


- [x] Resultado esperado:

![alt text](https://github.com/rochaeduardo/CRUD-POO-TESI/blob/main/saida-console.png)

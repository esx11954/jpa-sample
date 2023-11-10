"# jpa-sample" 

データベースのクライアントから以下のクエリを実行して下さい。

```
CREATE DATABASE IF NOT EXISTS item;

CREATE TABLE IF NOT EXISTS item (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255),
  price int,
  vendor varchar(255),
  PRIMARY KEY (id)
);
```

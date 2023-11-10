# DB環境 # 

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

# JPA概要 #

build.gradleのdependenciesに以下を追加

```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
```

---
#### Entityクラスを作成する 
---
クラスに`@Entity`アノテーションを付与する必要がある  
本プロジェクトにおけるItemクラス  
このクラスがDBのテーブルカラムに対応するフィールドと、それに対するgetter, setter等を持つ  


基本的には一意の列としての役割を持つフィールドに`@Id`アノテーションを付与する  
`@OneToOne`, `@OneToMany`等により結合も可能  



---
#### Entity毎のRepositoryインタフェースを作成する
---
作成したインターフェースには`@Repository`を付与する必要がある  
本プロジェクトにおけるItemRepositoryインターフェース  
Spring Dataから提供されているインタフェースを継承し、Entity毎のRepositoryインタフェースを作成する  
他にも方法はあるが、特に理由がない場合はの方法でEntity毎のRepositoryインタフェースを作成することを推奨されている  

###### Spring Dataから提供されているインタフェース
| インターフェース名 | 説明 |
| --- | --- |
|CrudRepository            |汎用的なCRUD操作を行うメソッドを提供  |
|PagingAndSortingRepository|CrudRepository のfindAllメソッドにページネーション機能とソート機能を提供|
|JpaRepository             |PagingAndSortingRepository を継承しているため、PagingAndSortingRepository および CrudRepository のメソッドも使用する事ができる|

継承したインターフェースには基本的なCRUD処理に相当するメソッドが用意されているが、  
標準のメソッド以外のクエリーを作るにはRepositoryインターフェイスにクエリメソッドを追加する。  
クエリメソッドの実装方法は以下の通り。  

- 命名規約に従ったメソッド名での自動実装
- @Queryアノテーションでのクエリー指定
- リポジトリ実装クラスでクエリーを実装する
- Specificationでの実装

`@Query`アノテーションを使用する場合は*JPQL*の習得が必要になる

#### 上記の使用方法
サービスクラスに`@Autowired`でインジェクションし、目的によってメソッドを作成する




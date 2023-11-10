# 環境 # 

データベースのクライアントから以下のクエリを実行して下さい。

```SQL
CREATE DATABASE IF NOT EXISTS item;

USE item;

CREATE TABLE IF NOT EXISTS item (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255),
  price int,
  vendor varchar(255),
  PRIMARY KEY (id)
);
```
build.gradleのdependenciesに以下を追加

```JAVA
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
```



# JPA概要 #
JPAとは、Javaで標準的に利用されるAPIの一種で、  
データの永続的な保管や取り出しを容易にする機能を提供するもの  
具体的にはオブジェクトの内容をデータベースに保存し、  
必要に応じて取り出してオブジェクトを再構築する技術
- ソースコードの書きやすさや管理のしやすさ  
- 基本的にはSQLを記載しないで、DBとJavaオブジェクトを連携できる


等のメリットが挙げられるが、複雑な問合せはできないことはないが得意とはしない


# 使用方法

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







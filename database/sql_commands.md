## SQL

# Some of The Most Important SQL Commands

- `SELECT` - extracts data from a database
- `UPDATE` - updates data in a database
- `DELETE` - deletes data from a database
- `INSERT INTO` - inserts new data into a database
- `CREATE DATABASE` - creates a new database
- `ALTER DATABASE` - modifies a database
- `CREATE TABLE` - creates a new table
- `ALTER TABLE` - modifies a table
- `DROP TABLE` - deletes a table
- `CREATE INDEX` - creates an index (search key)
- `DROP INDEX` - deletes an index

TABLE commands:

- ALTER TABLE <db-name> //to write into table
- ADD <column> <TYPE> //adding column
  - types:
    INT(size) DECIMAL(size) VARCHAR(size) DATE DATETIME
- RENAME <table_name> TO <new>
- MODIFY
  - MODIFY COLUMN <column_name> <new_variable> //change variable or it’s size
  - MODIFY <column_name> <type> AFTER <column_name> //change position
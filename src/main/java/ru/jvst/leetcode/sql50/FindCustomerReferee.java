package ru.jvst.leetcode.sql50;

/**
<a href="https://leetcode.com/problems/find-customer-referee/">584. Find Customer Referee</a>
<div class="xFUwe" data-track-load="description_content"><p>Table: <code>Customer</code></p>

<pre>+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| referee_id  | int     |
+-------------+---------+
In SQL, id is the primary key column for this table.
Each row of this table indicates the id of a customer, their name, and the id of the customer who referred them.
</pre>

<p>&nbsp;</p>

<p>Find the names of the customer that are <strong>not referred by</strong> the customer with <code>id = 2</code>.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> 
Customer table:
+----+------+------------+
| id | name | referee_id |
+----+------+------------+
| 1  | Will | null       |
| 2  | Jane | null       |
| 3  | Alex | 2          |
| 4  | Bill | null       |
| 5  | Zack | 1          |
| 6  | Mark | 2          |
+----+------+------------+
<strong>Output:</strong> 
+------+
| name |
+------+
| Will |
| Jane |
| Bill |
| Zack |
+------+
</pre>
</div>
**/

class FindCustomerReferee {
    String SQL = """
            SELECT name
            FROM Customer
            WHERE referee_id != '2'
            OR referee_id IS NULL;
            """;
}
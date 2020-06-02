select * from issue

SELECT nextval('issue_seq');

SELECT lastval()

select min_value, max_value,increment_by from pg_sequences where sequencename = 'issue_seq';

select * from pg_sequences

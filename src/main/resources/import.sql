INSERT INTO tb_departments(dpt_name) VALUES ('Marketing');
INSERT INTO tb_departments(dpt_name) VALUES ('Contábil');
INSERT INTO tb_departments(dpt_name) VALUES ('Financeiro');
INSERT INTO tb_departments(dpt_name) VALUES ('TI');

INSERT INTO tb_jobpositions(job_name, job_description) VALUES ('Analista', 'Organizar, analisar e controlar fluxos de trabalho');
INSERT INTO tb_jobpositions(job_name, job_description) VALUES ('Supervisor', 'Conduzir, direcionar e orientar processos e funcionários');
INSERT INTO tb_jobpositions(job_name, job_description) VALUES ('Assistente', 'Prestar atendimento e suporte');

INSERT INTO tb_employees(emp_name, emp_address, emp_hiringDate, dpt_id, job_id) VALUES ('Maria Silva', 'Rua das Margaridas 234', '2021-02-23', 2, 1);
INSERT INTO tb_employees(emp_name, emp_address, emp_hiringDate, dpt_id, job_id) VALUES ('Bob Amarante', 'Av. Botinal 555', '2010-01-13', 3, 1);
INSERT INTO tb_employees(emp_name, emp_address, emp_hiringDate, dpt_id, job_id) VALUES ('Alex Titius', 'Rua Laranepes 432', '2020-05-27', 1, 3);
INSERT INTO tb_employees(emp_name, emp_address, emp_hiringDate, dpt_id, job_id) VALUES ('Laura Pitt', 'Rua Pantanal 211', '2011-11-30', 2, 1);
INSERT INTO tb_employees(emp_name, emp_address, emp_hiringDate, dpt_id, job_id) VALUES ('Mario Bordi', 'Av. Castelão 897', '2019-06-29', 4, 3);
INSERT INTO tb_employees(emp_name, emp_address, emp_hiringDate, dpt_id, job_id) VALUES ('Kalin Linnas', 'Rua da Distron 2311', '2017-08-23', 4, 2);

INSERT INTO tb_users(usr_email, usr_password) VALUES ('admin@rh.com', 'admin123');
INSERT INTO tb_users(usr_email, usr_password) VALUES ('teste@rh.com', 'teste123');
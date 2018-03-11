insert into task (name, description, datefrom, dateto, uusername, status) values ('task1', 'description1 you are teacher1', '2017-11-20', '2017-12-03', 'teacher1', 'active');
insert into task (name, description, datefrom, dateto, uusername, status) values ('task2', 'description2 you are teacher1', '2017-11-21', '2017-12-17', 'teacher1', 'active');
insert into task (name, description, datefrom, dateto, uusername, status) values ('task3', 'description3 you are teacher1', '2017-12-08', '2017-12-11', 'teacher1', 'inactive');
insert into task (name, description, datefrom, dateto, uusername, status) values ('task4', 'description4 you are teacher1', '2017-11-10', '2017-12-30', 'teacher1', 'active');
insert into task (name, description, datefrom, dateto, uusername, status) values ('task5', 'description5 you are teacher1', '2017-11-15', '2017-12-20', 'teacher1', 'active');
insert into task (name, description, datefrom, dateto, uusername, status) values ('task6', 'description6 you are teacher2', '2017-12-01', '2017-12-14', 'teacher2', 'active');
insert into task (name, description, datefrom, dateto, uusername, status) values ('task7', 'description7 you are teacher2', '2017-11-01', '2017-12-10', 'teacher2', 'inactive');

insert into user (username, password, enabled, role) values ('teacher1', 'teacher1', 1, 'ROLE_ADMIN');
insert into user (username, password, enabled, role) values ('teacher2', 'teacher2', 1, 'ROLE_USER');
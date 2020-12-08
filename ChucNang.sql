use QLBVMB;

// them may bay
delimiter $$
create procedure insert_airplane(planeno varchar(15), kind varchar(40), brand varchar(40), numofseats int)
begin
	insert into maybay set mamb = planeno, loai = kind, hang = brand, soghe = numofseats;
end; $$
delimiter ;

// xoa may bay
delimiter $$
create procedure delete_airplane(planeno varchar(15))
begin
	delete maybay from maybay where mamb = planeno;
end; $$
delimiter ;

// them san bay
delimiter $$
create procedure insert_airport(airportno varchar(15), name varchar(40), nation varchar(30))
begin
	insert into sanbay set masb = airportno, tensb = name, quocgia = nation;
end; $$
delimiter ;

// xoa san bay
delimiter $$
create procedure delete_airport(airportno varchar(15))
begin
	delete sanbay from sanbay where masb = airportno;
end; $$
delimiter ;

// update luong nhan vien
DELIMITER $$
CREATE PROCEDURE update_sal(per int, empno varchar(15))
BEGIN
   update NhanVien set luong = ((luong*per)+luong) where MaNV = empno;
END; $$
DELIMITER ;

// xoa nhan vien
delimiter $$
create procedure delete_emp(empno varchar(15))
begin
	delete NhanVien from NhanVien where MaNV = empno;
end; $$
DELIMITER ;

// thêm nhân vien
delimiter $$
create procedure insert_emp(empno varchar(15), name varchar(40), sal int, dob date, msb varchar(40))
begin
	insert into NhanVien set manv = empno, ten = name, luong = sal, ngaysinh = dob, masb = msb;
end; $$
delimiter ;

// huy chuyen bay
delimiter $$
create procedure delete_flight(flightno varchar(15))
begin
	delete ChuyenBay from ChuyenBay where MaCB = flightno;
end; $$
delimiter ;

// them chuyen bay
delimiter $$
create procedure insert_flight(flightno varchar(15), planeno varchar(15), startpoint varchar(15), endpoint varchar(15), dayfly date)
begin
	insert into ChuyenBay set macb = flightno, mamb = planeno, masbdi = startpoint, masbden = endpoint, ngaybay = dayfly; 
end; $$
delimiter ;

// them ve moi
delimiter $$
create procedure insert_ticket(ticketno varchar(15), flightno varchar(15), nameofpassenger varchar(40), pport varchar(15), price int, unit varchar(10))
begin
	insert into ve set mave = ticketno, macb = flightno, tenhanhkhach = nameofpassenger, passport = pport, giave = price, donvitien = unit;
end; $$
delimiter ;

// huy ve 
delimiter $$
create procedure delete_ticket(ticketno varchar(15))
begin
	delete ve from ve where mave = ticketno;
end; $$


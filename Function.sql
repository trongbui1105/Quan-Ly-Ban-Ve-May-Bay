use QLBVMB;

-- them chuyen bay
DELIMITER $$
Create Procedure insertFlight(flightno varchar(15), planeno varchar(15), start_point varchar(15), end_point varchar(15), dayfly date)	
BEGIN
INSERT INTO chuyenbay 
VALUES (flightno, planeno, start_point, end_point, dayfly);
END; $$
DELIMITER ;

call insertFlight('CB21', 'MB8', 'TSN', 'NY', '2021/01/12');

-- huy chuyen bay
delimiter $$
create procedure deleteFlight(flightno varchar(15))
begin
	delete ChuyenBay from ChuyenBay where MaCB = flightno;
end; $$
delimiter ;

call deleteFlight('CB18');

-- sua chuyen bay
delimiter $$
create procedure updateFlight(flightno varchar(15), newFlightNo varchar(15), planeno varchar(15),
										start_point varchar(15), end_point varchar(15), dayfly date)
begin
	update chuyenbay c join ve v on c.maCB=v.maCB set c.maCB=newFlightNo, v.maCB=newFlightNo,
			maMB=planeno, maSBdi=start_point, maSBden=end_point, ngayBay=dayfly where c.maCB=flightno;
end; $$
delimiter ;

call updateFlight('CB28', 'CB99', 'MB6', 'CT','TSN', '2020/12/15');

-- tim ma chuyen bay
delimiter $$
create procedure findFlightID(flightno varchar(15))
begin
	select * from chuyenbay where maCB=flightno;
end; $$
delimiter ;

call findFlightID('CB21');


-- them ve moi
DELIMITER $$
Create Procedure insertTicket(ticketID varchar(15), planeID varchar(15), passengerName varchar(40), passport varchar(15), priceTicket int(10))	
BEGIN
INSERT INTO ve
VALUES (ticketID, planeID, passengerName, passport, priceTicket, 'USD');
END; $$
DELIMITER ;

call insertTicket('V23', 'CB23', 'Lionel Messi', '3127831321', 170);

-- huy ve
delimiter $$
create procedure deleteTicket(ticketID varchar(15))
begin
	delete from Ve where maVe = ticketID;
end; $$
delimiter ;

call deleteTicket('V25');

-- sua ve
delimiter $$
create procedure updateTicket(ticketID varchar(15), planeID varchar(15), passengerName varchar(40), passport varchar(15), priceTicket int(10))
begin
	update ve set maVe=ticketID, maCB=planeID, TenHanhKhach=passengerName, passport=passport, giaVe=priceTicket where maVe=ticketID;
end; $$
delimiter ;

call updateTicket('V23', 'CB23', 'Lionel Messi', '1375263183', 210);

-- tim ve
delimiter $$
create procedure findTicketID(ticketID varchar(15))
begin
	select * from ve where maVe=ticketID;
end; $$
delimiter ;

call findTicketID('V21');

-- tim ma chuyen bay tu Ve
delimiter $$
create procedure findFlightIDfromVe(flightno varchar(15))
begin
	select * from ve where maCB=flightno;
end; $$
delimiter ;

call findFlightIDfromVe('CB21');


-- them may bay
DELIMITER $$
Create Procedure insertPlane(planeID varchar(15), typeOfPlane varchar(40), airline varchar(40), numOfChair int(5))	
BEGIN
INSERT INTO maybay
VALUES (planeID, typeOfPlane, airline, numOfChair);
END; $$
DELIMITER ;

call insertPlane('MB11', 'Viking Air', 'Vietnam Airline', 200);

-- xoa may bay
delimiter $$
create procedure deletePlane(planeID varchar(15))
begin
	delete from maybay where maMB = planeID;
end; $$
delimiter ;

call deletePlane('MB12');

-- sua may bay
delimiter $$
create procedure updatePlane(newPlaneID varchar(15), planeID varchar(15), typeOfPlane varchar(40), airline varchar(40), numOfChair int(5))
begin
	update maybay set maMB=newPlaneID, loai=typeOfPlane, hang=airline, soGhe=numOfChair where maMB=planeID;
end; $$
delimiter ;

call updatePlane('MB22', 'MB11', 'Viking Air', 'Vietnam Airline', 230);

-- tim may bay
delimiter $$
create procedure findPlaneID(planeID varchar(15))
begin
	select * from maybay where maMB=planeID;
end; $$
delimiter ;

call findPlaneID('MB11');

-- them san bay
DELIMITER $$
Create Procedure insertAirport(idAirport varchar(15), nameOfAirport varchar(40), country varchar(30))	
BEGIN
INSERT INTO sanbay
VALUES (idAirport, nameOfAirport, country);
END; $$
DELIMITER ;

call insertAirport('PUS', 'Busan', 'Hàn Quốc');

-- sua san bay
delimiter $$
create procedure updateAirport(idAirport varchar(15), newIDAirport varchar(15), nameOfAirport varchar(40), country varchar(30))
begin
	update sanbay s join chuyenbay c on s.maSB=c.maSBdi join chuyenbay c1 on s.maSB=c1.maSBden join nhanvien nv on s.maSB=nv.maSB
    set s.maSB=newIDAirport, c.maSBdi=newIDAirport, c1.maSBden=newIDAirport, nv.maSB=newIDAirport, tenSB=nameOfAirport, quocgia=country
            where s.maSB=idAirport;
end; $$
delimiter ;

call updateAirport('BEJ', 'BJ', 'Beijing', 'China');
-- call updateAirport('BEJ', 'BJ', 'Bangkok IA', 'ThaiLand');

-- xoa san bay
delimiter $$
create procedure deleteAirport(idAirport varchar(15))
begin
	delete from sanbay where maSB = idAirport;
end; $$
delimiter ;

call deleteAirport('TAE');

-- tim ma san bay
delimiter $$
create procedure findIDAirport(idAirport varchar(15))
begin
	select * from sanbay where maSB=idAirport;
end; $$
delimiter ;

call findIDAirport('BKK');

-- them nhan vien
DELIMITER $$
Create Procedure insertEmp(idEmp varchar(15), nameOfEmp varchar(40), salary int(10), DOB date, idAirport varchar(40))	
BEGIN
INSERT INTO nhanvien
VALUES (idEmp, nameOfEmp, salary, DOB, idAirport);
END; $$
DELIMITER ;

call insertEmp('NV6', 'Dương Hữu Thắng', 1000, '2000/02/29', 'BKK');

-- xoa nhan vien
delimiter $$
create procedure deleteEmp(idEmp varchar(15))
begin
	delete from nhanvien where maNV = idEmp;
end; $$
delimiter ;

call deleteEmp('NV6');

-- sua nhan vien
delimiter $$
create procedure updateEmp(idEmp varchar(15), newIDEmp varchar(15), nameOfEmp varchar(40), salary int(10), DOB date, idAirport varchar(40))
begin
	update nhanvien set maNv=newIDEmp, hoTen=nameOfEmp, luong=salary, ngaysinh=DOB, maSB=idAirport where maNV=idEmp;
end; $$
delimiter ;

call updateEmp('NV6', 'NV7', 'Dương Hữu Thắng', 1000, '2000/02/29', 'BKK');

-- tim ma nhan vien
delimiter $$
create procedure findIDEmp(idEmp varchar(15))
begin
	select * from nhanvien where maNV=idEmp;
end; $$
delimiter ;

call findIDEmp('NV2');




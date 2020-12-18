create database QLBVMB character set utf8mb4;

use QLBVMB;

create table sanbay (
	MaSB varchar(15) primary key unique,
    TenSB varchar(40) not null,
    QuocGia varchar(30) not null
);
insert into sanbay values ('TSN', 'Tân Sơn Nhất', 'Viêt Nam');
insert into sanbay values ('NB', 'Nội Bài', 'Viêt Nam');
insert into sanbay values ('CT', 'Cần Thơ', 'Viêt Nam');
insert into sanbay values ('IC', 'Incheon', 'Hàn Quốc');
insert into sanbay values ('PQ', 'Phú Quốc', 'Việt Nam');
insert into sanbay values ('ĐN', 'Đà Nẵng', 'Việt Nam');
insert into sanbay values ('CCG', 'Chicago', 'Hoa Kỳ');
insert into sanbay values ('NY', 'New York', 'Hoa Kỳ');
insert into sanbay values ('BJ', 'Beijing', 'Trung Quốc');
insert into sanbay values ('CG', 'Changi', 'Singapore');
insert into sanbay values ('BK', 'Bangkok IA', 'Thái Lan');
insert into sanbay values ('HK', 'Hong Kong IA', 'Hồng Kông');

create table maybay (
	MaMB varchar(15) primary key unique not null,
    Loai varchar(40) not null,
    Hang varchar(40) not null,
    SoGhe int(5) not null check(SoGhe>0)
);


insert into maybay values('MB1', 'Boeing', 'Vietnam Airlines', 250);
insert into maybay values('MB2', 'Airbus', 'Bamboo Airlines', 150);
insert into maybay values('MB3', 'Boeing', 'China Airlines', 300);
insert into maybay values('MB4', 'Airbus', 'Korea Airlines', 280);
insert into maybay values('MB5', 'Fokker', 'VietJet', 180);
insert into maybay values('MB6', 'Fokke', 'HongKong Airlines', 150);
insert into maybay values('MB7', 'Boeing', 'Singapore Airlines', 200);
insert into maybay values('MB8', 'Airbus', 'Thailand Airlines', 180);
insert into maybay values('MB9', 'Boeing', 'American Airlines', 300);
insert into maybay values('MB10', 'Boeing', 'United Airlines', 280);

create table chuyenbay (
	MaCB varchar(15) primary key unique not null,
    MaMB varchar(15) not null,
    MaSBdi varchar(15) ,
    MaSBden varchar(15) ,
    NgayBay date not null,
    constraint FK_MASBDI foreign key(MaSBdi) references sanbay(MaSB),
	constraint FK_MASBDEN foreign key(MaSBden) references sanbay(MaSB),
    constraint FK_MAMB foreign key(MaMB) references maybay(MAMB)
);

ALTER TABLE chuyenbay
    DROP FOREIGN KEY FK_MASBDI,
    DROP FOREIGN KEY FK_MASBDEN,
    DROP FOREIGN KEY FK_MAMB;
ALTER TABLE chuyenbay
    ADD CONSTRAINT FK_MASBDI
        FOREIGN KEY (MaSBdi) 
        REFERENCES sanbay(MaSB)
        ON DELETE set null
        ON UPDATE CASCADE,
    ADD CONSTRAINT FK_MASBDEN
        FOREIGN KEY (MaSBden) 
        REFERENCES sanbay(MaSB)
        ON DELETE set null
        ON UPDATE CASCADE,
	ADD CONSTRAINT FK_MAMB
        FOREIGN KEY (MaMB) 
        REFERENCES maybay(MAMB)
        ON DELETE set null
        ON UPDATE CASCADE;

insert into chuyenbay values ('CB1', 'MB2', 'TSN','BJ', '2020/11/25');
insert into chuyenbay values ('CB2', 'MB5', 'IC','CT', '2020/11/30');
insert into chuyenbay values ('CB3', 'MB4', 'NB','IC', '2020/12/01');
insert into chuyenbay values ('CB4', 'MB1', 'BJ','NB', '2021/12/05');
insert into chuyenbay values ('CB5', 'MB3', 'BJ','IC', '2020/12/15');
insert into chuyenbay values ('CB6', 'MB2', 'CT','TSN', '2020/12/25');
insert into chuyenbay values ('CB7', 'MB5', 'CT','IC', '2020/01/01');
insert into chuyenbay values ('CB8', 'MB3', 'IC','BJ', '2020/01/10');
insert into chuyenbay values ('CB9', 'MB1', 'TSN','CT', '2020/01/25');
insert into chuyenbay values ('CB10', 'MB4', 'IC','NB', '2020/01/28');
insert into chuyenbay values ('CB11', 'MB10', 'NY','DN', '2020/03/28');
insert into chuyenbay values ('CB12', 'MB7', 'PQ','CG', '2020/04/01');
insert into chuyenbay values ('CB13', 'MB6', 'HK','PQ', '2020/04/11');
insert into chuyenbay values ('CB14', 'MB9', 'CCG','IC', '2020/04/20');
insert into chuyenbay values ('CB15', 'MB8', 'BK','NY', '2020/04/22');
insert into chuyenbay values ('CB16', 'MB10', 'NY','TSN', '2020/04/28');
insert into chuyenbay values ('CB17', 'MB9', 'BJ','CCG', '2020/05/01');
insert into chuyenbay values ('CB18', 'MB1', 'NB','NY', '2020/05/07');
insert into chuyenbay values ('CB19', 'MB2', 'CT','BK', '2020/05/11');
insert into chuyenbay values ('CB20', 'MB4', 'CG','IC', '2020/05/15');

create table ve (
	MaVe varchar(15) primary key unique not null,
    MaCB varchar(15) unique,
    TenHanhKhach varchar(40) not null,
    Passport varchar(15) not null,
    GiaVe int(10) not null check(giave>0),
    DonViTien varchar(10) not null,
    constraint FK_MACB foreign key(MaCB) references chuyenbay(MaCB)
);

ALTER TABLE ve
    DROP FOREIGN KEY FK_MACB ;
ALTER TABLE ve
    ADD CONSTRAINT FK_MACB
        FOREIGN KEY (MaCB) 
        REFERENCES chuyenbay(MaCB)
        ON DELETE set null
        ON UPDATE CASCADE;

insert into ve values ('V1', 'CB1', 'Bùi Quốc Trọng', '2314509732',100, 'USD');
insert into ve values ('V2', 'CB2', 'Dương Đăng Khoa', '2303852937', 150,'USD');
insert into ve values ('V3', 'CB3', 'Ngô Hồng Quốc Bảo', '2314947290',130, 'USD');
insert into ve values ('V4', 'CB4', 'Bùi Quốc Trọng', '2314509732', 80 ,'USD');
insert into ve values ('V5', 'CB5', 'Mai Phước Vinh', '2057395729', 95 ,'USD');
insert into ve values ('V6', 'CB6', 'Huỳnh Quang Nhật Hào', '2320580759', 100,'USD');
insert into ve values ('V7', 'CB7', 'Lê Chánh Nhựt', '3719627710', 150,'USD');
insert into ve values ('V8', 'CB8', 'Trương Hoàng Thuận', '3302857923', 130,'USD');
insert into ve values ('V9', 'CB9', 'Dương Hữu Thắng', '3601947592', 99 ,'USD');
insert into ve values ('V10', 'CB10', 'Đặng Nguyễn Phú Nguyên', '3801958374', 50, 'USD');
insert into ve values ('V11', 'CB11', 'Son Heung-min', '8571957293', 120, 'USD');
insert into ve values ('V12', 'CB12', 'Nguyễn Công Phượng', '3750385729', 75, 'USD');
insert into ve values ('V13', 'CB13', 'Châu Tinh Trì', '6281058201', 99 ,'USD');
insert into ve values ('V14', 'CB14', 'Justin Bieber', '5057107591', 200 ,'USD');
insert into ve values ('V15', 'CB15', 'Donald Trump', '5935917291', 250 ,'USD');
insert into ve values ('V16', 'CB16', 'Maria Ozawa', '2805892581', 190 ,'USD');
insert into ve values ('V17', 'CB17', 'Cổ Thiên Lạc', '5684918019', 205, 'USD');
insert into ve values ('V18', 'CB18', 'David Beckham', '4958937591', 185 ,'USD');
insert into ve values ('V19', 'CB19', 'Fernando Torres', '9581947501', 120 ,'USD');
insert into ve values ('V20', 'CB20', 'Park Hang-seo', '8492039581', 110 ,'USD');
insert into ve values ('V21', 'CB21', 'Nguyễn Chí Hoàng Minh', '3214333211', 120 ,'USD');
insert into ve values ('V23', 'CB23', 'Lionel Messi', '3127831321', 170 ,'USD');
delete from ve where maVe='V23';


create table nhanvien (
	MaNV varchar(15) primary key unique not null,
    HoTen varchar(40) not null,
    Luong int(10) not null check(Luong>0),
    NgaySinh date not null,
    MaSB varchar(40),
    constraint FK_MaSB foreign key(MaSB) references sanbay(MaSB)
);


ALTER TABLE nhanvien
    DROP FOREIGN KEY FK_MaSB;
ALTER TABLE nhanvien
    ADD CONSTRAINT FK_MaSB
        FOREIGN KEY (MaSB) 
        REFERENCES sanbay(MaSB)
        ON DELETE set null
        ON UPDATE CASCADE;

insert into nhanvien values ('NV1', 'Dương Đăng Khoa', 1000, '1990/01/05','TSN');
insert into nhanvien values ('NV2', 'Huỳnh Quang Nhật Hào', 1500, '1890/05/12','BJ');
insert into nhanvien values ('NV3', 'Nguyễn Chí Hoàng Minh', 800, '1995/05/29','NY');
insert into nhanvien values ('NV4', 'Nguyễn Nhĩ Thái', 1000, '1998/06/18','IC');
insert into nhanvien values ('NV5', 'Liêu Phúc Mai', 500, '2000/11/22','HK');









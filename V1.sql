create table categorias(
    id_cat int primary key,
    nombre_cat varchar(200)
);

create table productos(
    id_pro int primary key ,
    nombre_pro varchar(200),
    precio_pro decimal(10,2),
    id_cat int,
    foreign key (id_cat) references categorias(id_cat)
);


create table clientes(
    id_cli int primary key ,
    nombre_cli varchar(200),
    direccion_cli varchar(200),
    telefono_cli varchar(200),
    correo_cli varchar(200)
);

create table pedidos(
    id_pedidos int primary key ,
    fecha_pedido date,
    id_cli int,
    foreign key (id_cli) references clientes(id_cli)
);

create table trabajadores(
    id_traba int primary key ,
    nombre_traba varchar(200),
    cargo_traba varchar(200),
    salario_traba decimal(10,2)
);

create table proveedores(
    id_prov int primary key ,
    nombre_prov varchar(200),
    direccion_prov varchar(200),
    telefono_prov varchar(200)
);

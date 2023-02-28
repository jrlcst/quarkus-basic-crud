CREATE TABLE IF NOT EXISTS employee
(
    id           uuid         NOT NULL DEFAULT dbo.uuid_generate_v4(),
    first_name   varchar      NOT NULL,
    last_name    varchar(200) NOT NULL,
    birthday     date         NOT NULL,
    gender       varchar(50)  NOT NULL,
    phone_number varchar(50)  NOT NULL,
    CONSTRAINT employee_pkey PRIMARY KEY (id)
);
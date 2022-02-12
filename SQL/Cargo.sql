CREATE TABLE cargo(
    cargoId SERIAL NOT NULL,
    PRIMARY KEY (cargoId),
    status VARCHAR(50),
    name VARCHAR(50),
    weight INT,
    volume DECIMAL,
    departure VARCHAR(100),
    destination VARCHAR(100),
    sender VARCHAR(100),
    recipient VARCHAR(100)
)
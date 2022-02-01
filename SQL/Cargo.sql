CREATE TABLE cargo(
    cargoId SERIAL NOT NULL,
    PRIMARY KEY (cargoId),
    status VARCHAR(50),
    name VARCHAR(50),
    weight INT,
    volume DECIMAL,
    departure INT,
    destination INT,
    sender VARCHAR(100),
    recipient VARCHAR(100),
    CONSTRAINT departure_fk FOREIGN KEY (departure) REFERENCES city(cityId),
    CONSTRAINT destination_fk FOREIGN KEY (destination) REFERENCES city(cityId)
)
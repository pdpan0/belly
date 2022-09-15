CREATE TABLE IF NOT EXISTS tb_expenses (
	id_expense SERIAL PRIMARY KEY,
	description VARCHAR NOT NULL,
	amount BIGINT NOT NULL,
	created_at TIMESTAMP DEFAULT NOW(),
	id_ship INTEGER REFERENCES tb_ship
);
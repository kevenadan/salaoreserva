INSERT INTO usuario (id, nome, email, username, password, role) 
VALUES (1, 'Keven', 'keven@exemplo.com', 'admin', '$2a$12$ZjImHNh6Sgw1DeKdKhTpheh4rzjKjkf.KhcWxeRthRusoof3VPDQ2', 'ROLE_ADMIN')
ON CONFLICT (username) DO NOTHING;

INSERT INTO morador (id, unidade, telefone) 
VALUES (1, 'Unidade 101', '123456789')
ON CONFLICT (id) DO NOTHING;

INSERT INTO usuario (id, nome, email, username, password, role) 
VALUES (2, 'Morador', 'keven@exemplo.com', 'client', '$2a$12$2rkAoBzFepqIh0NKtXt.AOmrpEmkK30BMzWvin/CXIu9l1wvSeBhO', 'ROLE_USER')
ON CONFLICT (username) DO NOTHING;

INSERT INTO morador (id, unidade, telefone) 
VALUES (2, 'Unidade 101', '123456789')
ON CONFLICT (id) DO NOTHING;



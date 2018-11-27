INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES ('adminapp','mw/adminapp,ms/admin,ms/user','{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi','role_admin,role_superadmin','authorization_code,password,refresh_token,implicit',NULL,NULL,900,3600,'{}',NULL);

INSERT INTO user (id, username, password, email, enabled, account_expired, credentials_expired, account_locked, created_on, updated_on, version)
VALUES (1,'admin','{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi','admin@example.com','','\0','\0','\0','1970-01-01 00:00:00','1970-01-01 00:00:00',0);
INSERT INTO user (id, username, password, email, enabled, account_expired, credentials_expired, account_locked, created_on, updated_on, version)
VALUES (2,'user','{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi','user@example.com','','\0','\0','\0','1970-01-01 00:00:00','1970-01-01 00:00:00',0);

INSERT INTO role (id, name, created_on, updated_on, version)
VALUES (1,'role_admin','1970-01-01 00:00:00','1970-01-01 00:00:00',0);
INSERT INTO role (id, name, created_on, updated_on, version)
VALUES (2,'role_user','1970-01-01 00:00:00','1970-01-01 00:00:00',0);

INSERT INTO permission (id, name, created_on, updated_on, version)
VALUES (1,'can_delete_user','1970-01-01 00:00:00','1970-01-01 00:00:00',0);
INSERT INTO permission (id, name, created_on, updated_on, version)
VALUES (2,'can_create_user','1970-01-01 00:00:00','1970-01-01 00:00:00',0);
INSERT INTO permission (id, name, created_on, updated_on, version)
VALUES (3,'can_update_user','1970-01-01 00:00:00','1970-01-01 00:00:00',0);
INSERT INTO permission (id, name, created_on, updated_on, version)
VALUES (4,'can_read_user','1970-01-01 00:00:00','1970-01-01 00:00:00',0);

INSERT INTO permission_role (permission_id, role_id, created_on, updated_on, version)
VALUES (1,1,'1970-01-01 00:00:00','1970-01-01 00:00:00',0);
INSERT INTO permission_role (permission_id, role_id, created_on, updated_on, version)
VALUES (2,1,'1970-01-01 00:00:00','1970-01-01 00:00:00',0);
INSERT INTO permission_role (permission_id, role_id, created_on, updated_on, version)
VALUES (3,1,'1970-01-01 00:00:00','1970-01-01 00:00:00',0);
INSERT INTO permission_role (permission_id, role_id, created_on, updated_on, version)
VALUES (4,1,'1970-01-01 00:00:00','1970-01-01 00:00:00',0);
INSERT INTO permission_role (permission_id, role_id, created_on, updated_on, version)
VALUES (4,2,'1970-01-01 00:00:00','1970-01-01 00:00:00',0);

INSERT INTO role_user (role_id, user_id, created_on, updated_on, version)
VALUES (1,1,'1970-01-01 00:00:00','1970-01-01 00:00:00',0);
INSERT INTO role_user (role_id, user_id, created_on, updated_on, version)
VALUES (2,2,'1970-01-01 00:00:00','1970-01-01 00:00:00',0);




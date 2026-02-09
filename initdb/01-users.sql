-- This user is used by pgBouncer to run auth_query (needs permission to read pg_authid via a function)
CREATE USER pgbouncer_auth WITH PASSWORD 'authpass';

-- App user (the one your app will use)
CREATE USER appuser WITH PASSWORD 'apppass';

ALTER DATABASE appdb OWNER appuser;

-- Allow the auth user to connect to the DB used for auth_query
GRANT CONNECT ON DATABASE appdb TO pgbouncer_auth;

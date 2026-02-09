-- Make new passwords SCRAM
ALTER SYSTEM SET password_encryption = 'scram-sha-256';

-- Make sure host connections use SCRAM (safe for Docker)
ALTER SYSTEM SET password_encryption = 'scram-sha-256';
SELECT pg_reload_conf();

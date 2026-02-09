-- Function to return the stored password secret for a role (SCRAM secret)
-- SECURITY DEFINER lets it read pg_authid, but we restrict execute permissions.
CREATE OR REPLACE FUNCTION public.lookup_auth(user_name text)
RETURNS TABLE(username text, passwd text)
LANGUAGE sql
SECURITY DEFINER
AS $$
SELECT rolname::text, rolpassword::text
FROM pg_authid
WHERE rolname = user_name;
$$;

REVOKE ALL ON FUNCTION public.lookup_auth(text) FROM PUBLIC;
GRANT EXECUTE ON FUNCTION public.lookup_auth(text) TO pgbouncer_auth;

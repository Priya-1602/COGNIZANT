SELECT u.full_name, u.email 
   FROM Users u  
WHERE u.user_id NOT IN (
    SELECT r.user_id 
  FROM Registrations r  
    WHERE r.registration_date >= CURDATE() - INTERVAL 7 DAY
);


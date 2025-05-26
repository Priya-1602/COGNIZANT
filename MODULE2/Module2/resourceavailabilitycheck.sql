SELECT 
    e.title AS event_title
FROM 
    Events e
LEFT JOIN 
    Resources r ON e.event_id = r.event_id
WHERE 
    r.event_id IS NULL;

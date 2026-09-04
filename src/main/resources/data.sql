INSERT INTO service_tickets
(ticket_number,title,requester,category,priority,status,assigned_to,created_at,updated_at)
VALUES
('INC-1001','VPN connection not working','John Smith','NETWORK','HIGH','OPEN','IT Support',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1002','Laptop performance issue','Sarah Wilson','HARDWARE','MEDIUM','IN_PROGRESS','Desktop Support',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1003','Application access request','David Brown','ACCESS','HIGH','RESOLVED','IAM Team',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1004','Install Microsoft Office','Mike Johnson','SOFTWARE','LOW','RESOLVED','IT Support',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1005','Password reset required','Emily Davis','ACCESS','MEDIUM','OPEN','Service Desk',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1006','Email delivery problem','Robert Taylor','EMAIL','HIGH','IN_PROGRESS','Messaging Team',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1007','New employee account','Jessica Moore','ACCESS','MEDIUM','OPEN','IAM Team',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1008','Wi-Fi connectivity issue','Daniel Wilson','NETWORK','HIGH','OPEN','Network Team',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1009','Printer not responding','Olivia Martin','HARDWARE','LOW','RESOLVED','Desktop Support',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1010','VPN MFA issue','James Anderson','ACCESS','HIGH','IN_PROGRESS','IAM Team',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1011','Teams microphone issue','Sophia Thomas','HARDWARE','LOW','OPEN','Desktop Support',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1012','Shared drive access','William Jackson','ACCESS','MEDIUM','RESOLVED','IAM Team',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1013','Application error after update','Ava White','SOFTWARE','HIGH','OPEN','Application Support',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1014','Slow internet connection','Noah Harris','NETWORK','MEDIUM','IN_PROGRESS','Network Team',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP),
('INC-1015','Monitor replacement','Isabella Martin','HARDWARE','LOW','OPEN','Desktop Support',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

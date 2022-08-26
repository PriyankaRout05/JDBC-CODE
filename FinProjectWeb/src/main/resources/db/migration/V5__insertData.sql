-- NOTE please add new entries at the BEGINNING of the list so you don't need to worry about adding a comma or not
INSERT INTO
    public.users (
        email,
        password,
        first_name,
        middle_name,
        last_name,
        screen_name,
        internal_user,
        created_user,
        modified_user,
        created_on
    )
VALUES
    --Add new entries after this line
    (
        'admin@scriptbees.com',
        'admin',
        'Admin',
        'Admin',
        'Admin',
        'Administrator',
        true,
        -1,
        -1,
        now()
    );



INSERT INTO
    public.state (name,created_on, created_user, modified_user,modified_on,active )
VALUES
    --Add new entries after this line
    ('Andhra Pradesh',now(), 1, 1,now(),1 ),
    --Add new entries before this line
    ('Telangana', now(), 1, 1, now(),1)on conflict(name) do nothing;
    
    
    
    
insert into 
	public.district (name,state,created_on,created_user,modified_user,modified_on,active)
values
	('rajamahendravaram',(select id from public.state where name='Andhra Pradesh'),now(),1,1,now(),1),
        ('kurnool',(select id from public.state where name='Andhra Pradesh'),now(),1,1,now(),1)on conflict(name) do nothing; 
    
    
    
    
    
    
    
    
    
    


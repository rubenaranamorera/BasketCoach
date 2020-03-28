create table teams
(
    id        bigint,
    name      varchar,
    club_name varchar,
    created_at timestamp,
    updated_at timestamp,

    constraint pk_teams
        primary key (id)
);

comment on column teams.id is 'Id of the team';
comment on column teams.name is 'Name of the team';
comment on column teams.club_name is 'Name of the club of the team';
comment on column teams.created_at is 'Creation date of the team';
comment on column teams.updated_at is 'Update date of the team';

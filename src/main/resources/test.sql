select period.id, period.name, state.name from period inner join state on period.state = state.id ;

select * from applicant inner join applicant_subject on applicant.id = applicant_subject.applicant inner join user on applicant.user = user.id where subject=1 and period =5
select applicant.user from applicant join user on applicant.user = user.id
join status on applicant.status = status.id
left join speciality  on applicant.speciality = speciality.id
join period on applicant.period = period.id where applicant.user =4
select id from applicant where applicant.user=4 and period=5
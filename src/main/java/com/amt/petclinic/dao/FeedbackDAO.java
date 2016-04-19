package com.amt.petclinic.dao;

/*@Transactional
public class FeedbackDAO {

	private SessionFactory sessionFactory;

	public FeedbackDAO() {
		super();
	}

	public FeedbackDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Feedback> findAll() {
		List<Feedback> feedbackList = null;
		try {
			feedbackList = new ArrayList<Feedback>();
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Feedback f");
			feedbackList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feedbackList;
	}

	public void create(Feedback feedback) {
		try {
			sessionFactory.getCurrentSession().persist(feedback);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
*/
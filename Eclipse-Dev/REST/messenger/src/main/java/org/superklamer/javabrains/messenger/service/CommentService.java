package org.superklamer.javabrains.messenger.service;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.superklamer.javabrains.messenger.database.DatabaseClass;
import org.superklamer.javabrains.messenger.model.Message;
import org.superklamer.javabrains.messenger.model.Comment;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
}

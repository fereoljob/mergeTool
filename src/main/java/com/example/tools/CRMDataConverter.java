package com.example.tools;


import org.springframework.stereotype.Component;

import com.example.domain.ModelTO;


@Component
public interface CRMDataConverter<T> {
	public ModelTO convertDatas(T dataType);
}

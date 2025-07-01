:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).


solving_Path_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data],
dim(Self_data,[1,2,4]),

%CLG Path Constrints,
(Result = Self_data),

%Labeling Parts
labeling_Arrays([Self_data]).

:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

staticFixedsizeArrays_Cube_getData_DCC_Path_1(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_data,Self_dimensionSizes],Self_dimensionSizes = [1, 2, 4],

decl_Array(Self_data,Self_dimensionSizes),


%CLG Path Constrints,
(Result = Self_data),

%TypeVar Labeling Parts
labeling_Arrays([Self_data]).
